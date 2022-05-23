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
import com.ssafy.smartstore.data.local.dto.Comment;
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
public final class CommentDao_Impl implements CommentDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Comment> __insertionAdapterOfComment;

  private final EntityDeletionOrUpdateAdapter<Comment> __updateAdapterOfComment;

  private final SharedSQLiteStatement __preparedStmtOfDelete;

  public CommentDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfComment = new EntityInsertionAdapter<Comment>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `t_comment` (`user_id`,`product_id`,`rating`,`comment`,`id`) VALUES (?,?,?,?,nullif(?, 0))";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Comment value) {
        if (value.getUser_id() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUser_id());
        }
        stmt.bindLong(2, value.getProduct_id());
        stmt.bindDouble(3, value.getRating());
        if (value.getComment() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getComment());
        }
        stmt.bindLong(5, value.getId());
      }
    };
    this.__updateAdapterOfComment = new EntityDeletionOrUpdateAdapter<Comment>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `t_comment` SET `user_id` = ?,`product_id` = ?,`rating` = ?,`comment` = ?,`id` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Comment value) {
        if (value.getUser_id() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUser_id());
        }
        stmt.bindLong(2, value.getProduct_id());
        stmt.bindDouble(3, value.getRating());
        if (value.getComment() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getComment());
        }
        stmt.bindLong(5, value.getId());
        stmt.bindLong(6, value.getId());
      }
    };
    this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM t_comment WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final Comment comment, final Continuation<? super Long> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          long _result = __insertionAdapterOfComment.insertAndReturnId(comment);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object update(final Comment comment, final Continuation<? super Integer> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        int _total = 0;
        __db.beginTransaction();
        try {
          _total +=__updateAdapterOfComment.handle(comment);
          __db.setTransactionSuccessful();
          return _total;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object delete(final int commentId, final Continuation<? super Integer> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDelete.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, commentId);
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
  public Object select(final int commentId, final Continuation<? super Comment> continuation) {
    final String _sql = "SELECT * FROM t_comment WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, commentId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Comment>() {
      @Override
      public Comment call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
          final int _cursorIndexOfProductId = CursorUtil.getColumnIndexOrThrow(_cursor, "product_id");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final Comment _result;
          if(_cursor.moveToFirst()) {
            final String _tmpUser_id;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUser_id = null;
            } else {
              _tmpUser_id = _cursor.getString(_cursorIndexOfUserId);
            }
            final int _tmpProduct_id;
            _tmpProduct_id = _cursor.getInt(_cursorIndexOfProductId);
            final float _tmpRating;
            _tmpRating = _cursor.getFloat(_cursorIndexOfRating);
            final String _tmpComment;
            if (_cursor.isNull(_cursorIndexOfComment)) {
              _tmpComment = null;
            } else {
              _tmpComment = _cursor.getString(_cursorIndexOfComment);
            }
            _result = new Comment(_tmpUser_id,_tmpProduct_id,_tmpRating,_tmpComment);
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
  public Object selectAll(final Continuation<? super List<Comment>> continuation) {
    final String _sql = "SELECT * FROM t_comment";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Comment>>() {
      @Override
      public List<Comment> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
          final int _cursorIndexOfProductId = CursorUtil.getColumnIndexOrThrow(_cursor, "product_id");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final List<Comment> _result = new ArrayList<Comment>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Comment _item;
            final String _tmpUser_id;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUser_id = null;
            } else {
              _tmpUser_id = _cursor.getString(_cursorIndexOfUserId);
            }
            final int _tmpProduct_id;
            _tmpProduct_id = _cursor.getInt(_cursorIndexOfProductId);
            final float _tmpRating;
            _tmpRating = _cursor.getFloat(_cursorIndexOfRating);
            final String _tmpComment;
            if (_cursor.isNull(_cursorIndexOfComment)) {
              _tmpComment = null;
            } else {
              _tmpComment = _cursor.getString(_cursorIndexOfComment);
            }
            _item = new Comment(_tmpUser_id,_tmpProduct_id,_tmpRating,_tmpComment);
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
  public Object selectByProduct(final int productId,
      final Continuation<? super List<Comment>> continuation) {
    final String _sql = "SELECT * FROM t_comment WHERE product_id = ? ORDER BY id desc";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, productId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Comment>>() {
      @Override
      public List<Comment> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
          final int _cursorIndexOfProductId = CursorUtil.getColumnIndexOrThrow(_cursor, "product_id");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final List<Comment> _result = new ArrayList<Comment>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Comment _item;
            final String _tmpUser_id;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUser_id = null;
            } else {
              _tmpUser_id = _cursor.getString(_cursorIndexOfUserId);
            }
            final int _tmpProduct_id;
            _tmpProduct_id = _cursor.getInt(_cursorIndexOfProductId);
            final float _tmpRating;
            _tmpRating = _cursor.getFloat(_cursorIndexOfRating);
            final String _tmpComment;
            if (_cursor.isNull(_cursorIndexOfComment)) {
              _tmpComment = null;
            } else {
              _tmpComment = _cursor.getString(_cursorIndexOfComment);
            }
            _item = new Comment(_tmpUser_id,_tmpProduct_id,_tmpRating,_tmpComment);
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
