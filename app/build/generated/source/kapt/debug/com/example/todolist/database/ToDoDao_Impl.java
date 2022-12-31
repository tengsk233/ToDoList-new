package com.example.todolist.database;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.todolist.database.model.ToDoTask;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ToDoDao_Impl implements ToDoDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ToDoTask> __insertionAdapterOfToDoTask;

  private final EntityDeletionOrUpdateAdapter<ToDoTask> __deletionAdapterOfToDoTask;

  private final EntityDeletionOrUpdateAdapter<ToDoTask> __updateAdapterOfToDoTask;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllTasks;

  public ToDoDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfToDoTask = new EntityInsertionAdapter<ToDoTask>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `todo_table` (`id`,`title`,`description`,`time`,`status`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ToDoTask value) {
        stmt.bindLong(1, value.getId());
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescription());
        }
        if (value.getTime() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getTime());
        }
        final int _tmp = value.getStatus() ? 1 : 0;
        stmt.bindLong(5, _tmp);
      }
    };
    this.__deletionAdapterOfToDoTask = new EntityDeletionOrUpdateAdapter<ToDoTask>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `todo_table` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ToDoTask value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfToDoTask = new EntityDeletionOrUpdateAdapter<ToDoTask>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `todo_table` SET `id` = ?,`title` = ?,`description` = ?,`time` = ?,`status` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ToDoTask value) {
        stmt.bindLong(1, value.getId());
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescription());
        }
        if (value.getTime() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getTime());
        }
        final int _tmp = value.getStatus() ? 1 : 0;
        stmt.bindLong(5, _tmp);
        stmt.bindLong(6, value.getId());
      }
    };
    this.__preparedStmtOfDeleteAllTasks = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM todo_table";
        return _query;
      }
    };
  }

  @Override
  public Object addTask(final ToDoTask toDoTask, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfToDoTask.insert(toDoTask);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteTask(final ToDoTask toDoTask, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfToDoTask.handle(toDoTask);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object updateTask(final ToDoTask toDoTask, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfToDoTask.handle(toDoTask);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteAllTasks(final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllTasks.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteAllTasks.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Flow<List<ToDoTask>> getAllTasks() {
    final String _sql = "SELECT * FROM todo_table ORDER BY id ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"todo_table"}, new Callable<List<ToDoTask>>() {
      @Override
      public List<ToDoTask> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final List<ToDoTask> _result = new ArrayList<ToDoTask>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ToDoTask _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final Long _tmpTime;
            if (_cursor.isNull(_cursorIndexOfTime)) {
              _tmpTime = null;
            } else {
              _tmpTime = _cursor.getLong(_cursorIndexOfTime);
            }
            final boolean _tmpStatus;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfStatus);
            _tmpStatus = _tmp != 0;
            _item = new ToDoTask(_tmpId,_tmpTitle,_tmpDescription,_tmpTime,_tmpStatus);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<ToDoTask> getSelectedTask(final int taskId) {
    final String _sql = "SELECT * FROM todo_table WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, taskId);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"todo_table"}, new Callable<ToDoTask>() {
      @Override
      public ToDoTask call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final ToDoTask _result;
          if(_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final Long _tmpTime;
            if (_cursor.isNull(_cursorIndexOfTime)) {
              _tmpTime = null;
            } else {
              _tmpTime = _cursor.getLong(_cursorIndexOfTime);
            }
            final boolean _tmpStatus;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfStatus);
            _tmpStatus = _tmp != 0;
            _result = new ToDoTask(_tmpId,_tmpTitle,_tmpDescription,_tmpTime,_tmpStatus);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<ToDoTask>> searchDatabase(final String searchQuery) {
    final String _sql = "SELECT * FROM todo_table WHERE title LIKE ? OR description LIKE ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (searchQuery == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, searchQuery);
    }
    _argIndex = 2;
    if (searchQuery == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, searchQuery);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[]{"todo_table"}, new Callable<List<ToDoTask>>() {
      @Override
      public List<ToDoTask> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final List<ToDoTask> _result = new ArrayList<ToDoTask>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ToDoTask _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final Long _tmpTime;
            if (_cursor.isNull(_cursorIndexOfTime)) {
              _tmpTime = null;
            } else {
              _tmpTime = _cursor.getLong(_cursorIndexOfTime);
            }
            final boolean _tmpStatus;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfStatus);
            _tmpStatus = _tmp != 0;
            _item = new ToDoTask(_tmpId,_tmpTitle,_tmpDescription,_tmpTime,_tmpStatus);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<ToDoTask>> sortByNewTime() {
    final String _sql = "SELECT * FROM todo_table ORDER BY  time ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"todo_table"}, new Callable<List<ToDoTask>>() {
      @Override
      public List<ToDoTask> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final List<ToDoTask> _result = new ArrayList<ToDoTask>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ToDoTask _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final Long _tmpTime;
            if (_cursor.isNull(_cursorIndexOfTime)) {
              _tmpTime = null;
            } else {
              _tmpTime = _cursor.getLong(_cursorIndexOfTime);
            }
            final boolean _tmpStatus;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfStatus);
            _tmpStatus = _tmp != 0;
            _item = new ToDoTask(_tmpId,_tmpTitle,_tmpDescription,_tmpTime,_tmpStatus);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<ToDoTask>> sortByOldTime() {
    final String _sql = "SELECT * FROM todo_table ORDER BY time DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"todo_table"}, new Callable<List<ToDoTask>>() {
      @Override
      public List<ToDoTask> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final List<ToDoTask> _result = new ArrayList<ToDoTask>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ToDoTask _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final Long _tmpTime;
            if (_cursor.isNull(_cursorIndexOfTime)) {
              _tmpTime = null;
            } else {
              _tmpTime = _cursor.getLong(_cursorIndexOfTime);
            }
            final boolean _tmpStatus;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfStatus);
            _tmpStatus = _tmp != 0;
            _item = new ToDoTask(_tmpId,_tmpTitle,_tmpDescription,_tmpTime,_tmpStatus);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<ToDoTask>> getDoneTasks() {
    final String _sql = "SELECT * FROM todo_table WHERE status = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"todo_table"}, new Callable<List<ToDoTask>>() {
      @Override
      public List<ToDoTask> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final List<ToDoTask> _result = new ArrayList<ToDoTask>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ToDoTask _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final Long _tmpTime;
            if (_cursor.isNull(_cursorIndexOfTime)) {
              _tmpTime = null;
            } else {
              _tmpTime = _cursor.getLong(_cursorIndexOfTime);
            }
            final boolean _tmpStatus;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfStatus);
            _tmpStatus = _tmp != 0;
            _item = new ToDoTask(_tmpId,_tmpTitle,_tmpDescription,_tmpTime,_tmpStatus);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<ToDoTask>> getUndoneTasks() {
    final String _sql = "SELECT * FROM todo_table WHERE status = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"todo_table"}, new Callable<List<ToDoTask>>() {
      @Override
      public List<ToDoTask> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final List<ToDoTask> _result = new ArrayList<ToDoTask>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ToDoTask _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final Long _tmpTime;
            if (_cursor.isNull(_cursorIndexOfTime)) {
              _tmpTime = null;
            } else {
              _tmpTime = _cursor.getLong(_cursorIndexOfTime);
            }
            final boolean _tmpStatus;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfStatus);
            _tmpStatus = _tmp != 0;
            _item = new ToDoTask(_tmpId,_tmpTitle,_tmpDescription,_tmpTime,_tmpStatus);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<ToDoTask>> getTaskByDay(final long date) {
    final String _sql = "SELECT * FROM todo_table WHERE date(time/1000,'unixepoch')=date(?/1000)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, date);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"todo_table"}, new Callable<List<ToDoTask>>() {
      @Override
      public List<ToDoTask> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final List<ToDoTask> _result = new ArrayList<ToDoTask>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ToDoTask _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final Long _tmpTime;
            if (_cursor.isNull(_cursorIndexOfTime)) {
              _tmpTime = null;
            } else {
              _tmpTime = _cursor.getLong(_cursorIndexOfTime);
            }
            final boolean _tmpStatus;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfStatus);
            _tmpStatus = _tmp != 0;
            _item = new ToDoTask(_tmpId,_tmpTitle,_tmpDescription,_tmpTime,_tmpStatus);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
