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
import com.ssafy.smartstore.data.local.dto.Noti;
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
public final class NotiDao_Impl implements NotiDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Noti> __insertionAdapterOfNoti;

  private final SharedSQLiteStatement __preparedStmtOfDelete;

  public NotiDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfNoti = new EntityInsertionAdapter<Noti>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `t_noti` (`u_id`,`data`,`id`) VALUES (?,?,nullif(?, 0))";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Noti value) {
        if (value.getU_id() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getU_id());
        }
        if (value.getData() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getData());
        }
        stmt.bindLong(3, value.getId());
      }
    };
    this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM t_noti WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final Noti noti, final Continuation<? super Long> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          long _result = __insertionAdapterOfNoti.insertAndReturnId(noti);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object delete(final int id, final Continuation<? super Integer> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDelete.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
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
  public Object select(final String id, final Continuation<? super List<Noti>> continuation) {
    final String _sql = "SELECT * FROM t_noti WHERE u_id = ? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Noti>>() {
      @Override
      public List<Noti> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUId = CursorUtil.getColumnIndexOrThrow(_cursor, "u_id");
          final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final List<Noti> _result = new ArrayList<Noti>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Noti _item;
            final String _tmpU_id;
            if (_cursor.isNull(_cursorIndexOfUId)) {
              _tmpU_id = null;
            } else {
              _tmpU_id = _cursor.getString(_cursorIndexOfUId);
            }
            final String _tmpData;
            if (_cursor.isNull(_cursorIndexOfData)) {
              _tmpData = null;
            } else {
              _tmpData = _cursor.getString(_cursorIndexOfData);
            }
            _item = new Noti(_tmpU_id,_tmpData);
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
