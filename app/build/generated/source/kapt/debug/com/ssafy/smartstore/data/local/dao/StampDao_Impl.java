package com.ssafy.smartstore.data.local.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.ssafy.smartstore.data.local.dto.Stamp;
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
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class StampDao_Impl implements StampDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Stamp> __insertionAdapterOfStamp;

  public StampDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfStamp = new EntityInsertionAdapter<Stamp>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `t_stamp` (`user_id`,`order_id`,`quantity`,`id`) VALUES (?,?,?,nullif(?, 0))";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Stamp value) {
        if (value.getUser_id() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUser_id());
        }
        stmt.bindLong(2, value.getOrder_id());
        stmt.bindLong(3, value.getQuantity());
        stmt.bindLong(4, value.getId());
      }
    };
  }

  @Override
  public Object insert(final Stamp stamp, final Continuation<? super Long> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          long _result = __insertionAdapterOfStamp.insertAndReturnId(stamp);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object select(final int stampId, final Continuation<? super Stamp> continuation) {
    final String _sql = "SELECT * FROM t_stamp WHERE id =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, stampId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Stamp>() {
      @Override
      public Stamp call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
          final int _cursorIndexOfOrderId = CursorUtil.getColumnIndexOrThrow(_cursor, "order_id");
          final int _cursorIndexOfQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "quantity");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final Stamp _result;
          if(_cursor.moveToFirst()) {
            final String _tmpUser_id;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUser_id = null;
            } else {
              _tmpUser_id = _cursor.getString(_cursorIndexOfUserId);
            }
            final int _tmpOrder_id;
            _tmpOrder_id = _cursor.getInt(_cursorIndexOfOrderId);
            final int _tmpQuantity;
            _tmpQuantity = _cursor.getInt(_cursorIndexOfQuantity);
            _result = new Stamp(_tmpUser_id,_tmpOrder_id,_tmpQuantity);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _result.setId(_tmpId);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public Object selectAll(final Continuation<? super List<Stamp>> continuation) {
    final String _sql = "SELECT * FROM t_stamp";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Stamp>>() {
      @Override
      public List<Stamp> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
          final int _cursorIndexOfOrderId = CursorUtil.getColumnIndexOrThrow(_cursor, "order_id");
          final int _cursorIndexOfQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "quantity");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final List<Stamp> _result = new ArrayList<Stamp>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Stamp _item;
            final String _tmpUser_id;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUser_id = null;
            } else {
              _tmpUser_id = _cursor.getString(_cursorIndexOfUserId);
            }
            final int _tmpOrder_id;
            _tmpOrder_id = _cursor.getInt(_cursorIndexOfOrderId);
            final int _tmpQuantity;
            _tmpQuantity = _cursor.getInt(_cursorIndexOfQuantity);
            _item = new Stamp(_tmpUser_id,_tmpOrder_id,_tmpQuantity);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public Object selectByUserId(final String userId,
      final Continuation<? super List<Stamp>> continuation) {
    final String _sql = "SELECT * FROM t_stamp WHERE id = ? ORDER BY id desc";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Stamp>>() {
      @Override
      public List<Stamp> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
          final int _cursorIndexOfOrderId = CursorUtil.getColumnIndexOrThrow(_cursor, "order_id");
          final int _cursorIndexOfQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "quantity");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final List<Stamp> _result = new ArrayList<Stamp>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Stamp _item;
            final String _tmpUser_id;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUser_id = null;
            } else {
              _tmpUser_id = _cursor.getString(_cursorIndexOfUserId);
            }
            final int _tmpOrder_id;
            _tmpOrder_id = _cursor.getInt(_cursorIndexOfOrderId);
            final int _tmpQuantity;
            _tmpQuantity = _cursor.getInt(_cursorIndexOfQuantity);
            _item = new Stamp(_tmpUser_id,_tmpOrder_id,_tmpQuantity);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
