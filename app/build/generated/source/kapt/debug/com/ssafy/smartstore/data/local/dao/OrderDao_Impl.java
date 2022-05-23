package com.ssafy.smartstore.data.local.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.ssafy.smartstore.data.local.dto.Order;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
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
public final class OrderDao_Impl implements OrderDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Order> __insertionAdapterOfOrder;

  private final EntityDeletionOrUpdateAdapter<Order> __updateAdapterOfOrder;

  private final SharedSQLiteStatement __preparedStmtOfDelete;

  public OrderDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfOrder = new EntityInsertionAdapter<Order>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `t_order` (`user_id`,`order_table`,`order_time`,`completed`,`o_id`) VALUES (?,?,?,?,nullif(?, 0))";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Order value) {
        if (value.getUser_id() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUser_id());
        }
        if (value.getOrder_table() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getOrder_table());
        }
        if (value.getOrder_time() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getOrder_time());
        }
        stmt.bindLong(4, value.getCompleted());
        stmt.bindLong(5, value.getO_id());
      }
    };
    this.__updateAdapterOfOrder = new EntityDeletionOrUpdateAdapter<Order>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `t_order` SET `user_id` = ?,`order_table` = ?,`order_time` = ?,`completed` = ?,`o_id` = ? WHERE `o_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Order value) {
        if (value.getUser_id() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUser_id());
        }
        if (value.getOrder_table() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getOrder_table());
        }
        if (value.getOrder_time() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getOrder_time());
        }
        stmt.bindLong(4, value.getCompleted());
        stmt.bindLong(5, value.getO_id());
        stmt.bindLong(6, value.getO_id());
      }
    };
    this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM t_order WHERE o_id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final Order order, final Continuation<? super Long> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          long _result = __insertionAdapterOfOrder.insertAndReturnId(order);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object update(final Order order, final Continuation<? super Integer> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        int _total = 0;
        __db.beginTransaction();
        try {
          _total +=__updateAdapterOfOrder.handle(order);
          __db.setTransactionSuccessful();
          return _total;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object delete(final int orderId, final Continuation<? super Integer> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDelete.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, orderId);
        __db.beginTransaction();
        try {
          final java.lang.Integer _result = _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDelete.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Object select(final int orderId, final Continuation<? super Order> continuation) {
    final String _sql = "SELECT * FROM t_order WHERE o_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, orderId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Order>() {
      @Override
      public Order call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
          final int _cursorIndexOfOrderTable = CursorUtil.getColumnIndexOrThrow(_cursor, "order_table");
          final int _cursorIndexOfOrderTime = CursorUtil.getColumnIndexOrThrow(_cursor, "order_time");
          final int _cursorIndexOfCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "completed");
          final int _cursorIndexOfOId = CursorUtil.getColumnIndexOrThrow(_cursor, "o_id");
          final Order _result;
          if(_cursor.moveToFirst()) {
            final String _tmpUser_id;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUser_id = null;
            } else {
              _tmpUser_id = _cursor.getString(_cursorIndexOfUserId);
            }
            final String _tmpOrder_table;
            if (_cursor.isNull(_cursorIndexOfOrderTable)) {
              _tmpOrder_table = null;
            } else {
              _tmpOrder_table = _cursor.getString(_cursorIndexOfOrderTable);
            }
            final String _tmpOrder_time;
            if (_cursor.isNull(_cursorIndexOfOrderTime)) {
              _tmpOrder_time = null;
            } else {
              _tmpOrder_time = _cursor.getString(_cursorIndexOfOrderTime);
            }
            final char _tmpCompleted;
            _tmpCompleted = (char) _cursor.getInt(_cursorIndexOfCompleted);
            _result = new Order(_tmpUser_id,_tmpOrder_table,_tmpOrder_time,_tmpCompleted);
            final int _tmpO_id;
            _tmpO_id = _cursor.getInt(_cursorIndexOfOId);
            _result.setO_id(_tmpO_id);
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
  public Object selectAll(final Continuation<? super List<Order>> continuation) {
    final String _sql = "SELECT * FROM t_order";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Order>>() {
      @Override
      public List<Order> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
          final int _cursorIndexOfOrderTable = CursorUtil.getColumnIndexOrThrow(_cursor, "order_table");
          final int _cursorIndexOfOrderTime = CursorUtil.getColumnIndexOrThrow(_cursor, "order_time");
          final int _cursorIndexOfCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "completed");
          final int _cursorIndexOfOId = CursorUtil.getColumnIndexOrThrow(_cursor, "o_id");
          final List<Order> _result = new ArrayList<Order>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Order _item;
            final String _tmpUser_id;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUser_id = null;
            } else {
              _tmpUser_id = _cursor.getString(_cursorIndexOfUserId);
            }
            final String _tmpOrder_table;
            if (_cursor.isNull(_cursorIndexOfOrderTable)) {
              _tmpOrder_table = null;
            } else {
              _tmpOrder_table = _cursor.getString(_cursorIndexOfOrderTable);
            }
            final String _tmpOrder_time;
            if (_cursor.isNull(_cursorIndexOfOrderTime)) {
              _tmpOrder_time = null;
            } else {
              _tmpOrder_time = _cursor.getString(_cursorIndexOfOrderTime);
            }
            final char _tmpCompleted;
            _tmpCompleted = (char) _cursor.getInt(_cursorIndexOfCompleted);
            _item = new Order(_tmpUser_id,_tmpOrder_table,_tmpOrder_time,_tmpCompleted);
            final int _tmpO_id;
            _tmpO_id = _cursor.getInt(_cursorIndexOfOId);
            _item.setO_id(_tmpO_id);
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
  public Object selectWithDetail(final int id, final Continuation<? super Order> continuation) {
    final String _sql = "SELECT * FROM t_order WHERE o_id = (SELECT o_id FROM t_order_detail WHERE d_id = ? )";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Order>() {
      @Override
      public Order call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
          final int _cursorIndexOfOrderTable = CursorUtil.getColumnIndexOrThrow(_cursor, "order_table");
          final int _cursorIndexOfOrderTime = CursorUtil.getColumnIndexOrThrow(_cursor, "order_time");
          final int _cursorIndexOfCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "completed");
          final int _cursorIndexOfOId = CursorUtil.getColumnIndexOrThrow(_cursor, "o_id");
          final Order _result;
          if(_cursor.moveToFirst()) {
            final String _tmpUser_id;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUser_id = null;
            } else {
              _tmpUser_id = _cursor.getString(_cursorIndexOfUserId);
            }
            final String _tmpOrder_table;
            if (_cursor.isNull(_cursorIndexOfOrderTable)) {
              _tmpOrder_table = null;
            } else {
              _tmpOrder_table = _cursor.getString(_cursorIndexOfOrderTable);
            }
            final String _tmpOrder_time;
            if (_cursor.isNull(_cursorIndexOfOrderTime)) {
              _tmpOrder_time = null;
            } else {
              _tmpOrder_time = _cursor.getString(_cursorIndexOfOrderTime);
            }
            final char _tmpCompleted;
            _tmpCompleted = (char) _cursor.getInt(_cursorIndexOfCompleted);
            _result = new Order(_tmpUser_id,_tmpOrder_table,_tmpOrder_time,_tmpCompleted);
            final int _tmpO_id;
            _tmpO_id = _cursor.getInt(_cursorIndexOfOId);
            _result.setO_id(_tmpO_id);
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
  public Object selectByUser(final String userId,
      final Continuation<? super List<Order>> continuation) {
    final String _sql = "select * from t_order WHERE user_id = ? ORDER BY order_time desc";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Order>>() {
      @Override
      public List<Order> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
          final int _cursorIndexOfOrderTable = CursorUtil.getColumnIndexOrThrow(_cursor, "order_table");
          final int _cursorIndexOfOrderTime = CursorUtil.getColumnIndexOrThrow(_cursor, "order_time");
          final int _cursorIndexOfCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "completed");
          final int _cursorIndexOfOId = CursorUtil.getColumnIndexOrThrow(_cursor, "o_id");
          final List<Order> _result = new ArrayList<Order>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Order _item;
            final String _tmpUser_id;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUser_id = null;
            } else {
              _tmpUser_id = _cursor.getString(_cursorIndexOfUserId);
            }
            final String _tmpOrder_table;
            if (_cursor.isNull(_cursorIndexOfOrderTable)) {
              _tmpOrder_table = null;
            } else {
              _tmpOrder_table = _cursor.getString(_cursorIndexOfOrderTable);
            }
            final String _tmpOrder_time;
            if (_cursor.isNull(_cursorIndexOfOrderTime)) {
              _tmpOrder_time = null;
            } else {
              _tmpOrder_time = _cursor.getString(_cursorIndexOfOrderTime);
            }
            final char _tmpCompleted;
            _tmpCompleted = (char) _cursor.getInt(_cursorIndexOfCompleted);
            _item = new Order(_tmpUser_id,_tmpOrder_table,_tmpOrder_time,_tmpCompleted);
            final int _tmpO_id;
            _tmpO_id = _cursor.getInt(_cursorIndexOfOId);
            _item.setO_id(_tmpO_id);
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
