package com.ssafy.smartstore.data.local.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.ssafy.smartstore.data.local.dto.OrderDetail;
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
public final class OrderDetailDao_Impl implements OrderDetailDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<OrderDetail> __insertionAdapterOfOrderDetail;

  private final SharedSQLiteStatement __preparedStmtOfDelete;

  public OrderDetailDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfOrderDetail = new EntityInsertionAdapter<OrderDetail>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `t_order_detail` (`order_id`,`product_id`,`quantity`,`d_id`) VALUES (?,?,?,nullif(?, 0))";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, OrderDetail value) {
        stmt.bindLong(1, value.getOrder_id());
        stmt.bindLong(2, value.getProduct_id());
        stmt.bindLong(3, value.getQuantity());
        stmt.bindLong(4, value.getD_id());
      }
    };
    this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM t_order_detail WHERE d_id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final OrderDetail detail, final Continuation<? super Long> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          long _result = __insertionAdapterOfOrderDetail.insertAndReturnId(detail);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object delete(final int detailId, final Continuation<? super Integer> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDelete.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, detailId);
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
  public Object select(final int detailId, final Continuation<? super OrderDetail> continuation) {
    final String _sql = "SELECT * FROM t_order_detail WHERE d_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, detailId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<OrderDetail>() {
      @Override
      public OrderDetail call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfOrderId = CursorUtil.getColumnIndexOrThrow(_cursor, "order_id");
          final int _cursorIndexOfProductId = CursorUtil.getColumnIndexOrThrow(_cursor, "product_id");
          final int _cursorIndexOfQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "quantity");
          final int _cursorIndexOfDId = CursorUtil.getColumnIndexOrThrow(_cursor, "d_id");
          final OrderDetail _result;
          if(_cursor.moveToFirst()) {
            final int _tmpOrder_id;
            _tmpOrder_id = _cursor.getInt(_cursorIndexOfOrderId);
            final int _tmpProduct_id;
            _tmpProduct_id = _cursor.getInt(_cursorIndexOfProductId);
            final int _tmpQuantity;
            _tmpQuantity = _cursor.getInt(_cursorIndexOfQuantity);
            _result = new OrderDetail(_tmpOrder_id,_tmpProduct_id,_tmpQuantity);
            final int _tmpD_id;
            _tmpD_id = _cursor.getInt(_cursorIndexOfDId);
            _result.setD_id(_tmpD_id);
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
  public Object selectAll(final Continuation<? super List<OrderDetail>> continuation) {
    final String _sql = "SELECT * FROM t_order_detail";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<OrderDetail>>() {
      @Override
      public List<OrderDetail> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfOrderId = CursorUtil.getColumnIndexOrThrow(_cursor, "order_id");
          final int _cursorIndexOfProductId = CursorUtil.getColumnIndexOrThrow(_cursor, "product_id");
          final int _cursorIndexOfQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "quantity");
          final int _cursorIndexOfDId = CursorUtil.getColumnIndexOrThrow(_cursor, "d_id");
          final List<OrderDetail> _result = new ArrayList<OrderDetail>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final OrderDetail _item;
            final int _tmpOrder_id;
            _tmpOrder_id = _cursor.getInt(_cursorIndexOfOrderId);
            final int _tmpProduct_id;
            _tmpProduct_id = _cursor.getInt(_cursorIndexOfProductId);
            final int _tmpQuantity;
            _tmpQuantity = _cursor.getInt(_cursorIndexOfQuantity);
            _item = new OrderDetail(_tmpOrder_id,_tmpProduct_id,_tmpQuantity);
            final int _tmpD_id;
            _tmpD_id = _cursor.getInt(_cursorIndexOfDId);
            _item.setD_id(_tmpD_id);
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
  public Object selectByProductId(final int productId,
      final Continuation<? super List<OrderDetail>> continuation) {
    final String _sql = "SELECT * FROM t_order_detail WHERE product_id= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, productId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<OrderDetail>>() {
      @Override
      public List<OrderDetail> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfOrderId = CursorUtil.getColumnIndexOrThrow(_cursor, "order_id");
          final int _cursorIndexOfProductId = CursorUtil.getColumnIndexOrThrow(_cursor, "product_id");
          final int _cursorIndexOfQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "quantity");
          final int _cursorIndexOfDId = CursorUtil.getColumnIndexOrThrow(_cursor, "d_id");
          final List<OrderDetail> _result = new ArrayList<OrderDetail>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final OrderDetail _item;
            final int _tmpOrder_id;
            _tmpOrder_id = _cursor.getInt(_cursorIndexOfOrderId);
            final int _tmpProduct_id;
            _tmpProduct_id = _cursor.getInt(_cursorIndexOfProductId);
            final int _tmpQuantity;
            _tmpQuantity = _cursor.getInt(_cursorIndexOfQuantity);
            _item = new OrderDetail(_tmpOrder_id,_tmpProduct_id,_tmpQuantity);
            final int _tmpD_id;
            _tmpD_id = _cursor.getInt(_cursorIndexOfDId);
            _item.setD_id(_tmpD_id);
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
  public Object selectByOrderId(final int orderId,
      final Continuation<? super List<OrderDetail>> continuation) {
    final String _sql = "SELECT * FROM t_order_detail WHERE order_id= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, orderId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<OrderDetail>>() {
      @Override
      public List<OrderDetail> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfOrderId = CursorUtil.getColumnIndexOrThrow(_cursor, "order_id");
          final int _cursorIndexOfProductId = CursorUtil.getColumnIndexOrThrow(_cursor, "product_id");
          final int _cursorIndexOfQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "quantity");
          final int _cursorIndexOfDId = CursorUtil.getColumnIndexOrThrow(_cursor, "d_id");
          final List<OrderDetail> _result = new ArrayList<OrderDetail>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final OrderDetail _item;
            final int _tmpOrder_id;
            _tmpOrder_id = _cursor.getInt(_cursorIndexOfOrderId);
            final int _tmpProduct_id;
            _tmpProduct_id = _cursor.getInt(_cursorIndexOfProductId);
            final int _tmpQuantity;
            _tmpQuantity = _cursor.getInt(_cursorIndexOfQuantity);
            _item = new OrderDetail(_tmpOrder_id,_tmpProduct_id,_tmpQuantity);
            final int _tmpD_id;
            _tmpD_id = _cursor.getInt(_cursorIndexOfDId);
            _item.setD_id(_tmpD_id);
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
