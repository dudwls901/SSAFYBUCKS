package com.ssafy.smartstore.data.local.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.ssafy.smartstore.data.local.dao.CommentDao;
import com.ssafy.smartstore.data.local.dao.CommentDao_Impl;
import com.ssafy.smartstore.data.local.dao.NotiDao;
import com.ssafy.smartstore.data.local.dao.NotiDao_Impl;
import com.ssafy.smartstore.data.local.dao.OrderDao;
import com.ssafy.smartstore.data.local.dao.OrderDao_Impl;
import com.ssafy.smartstore.data.local.dao.OrderDetailDao;
import com.ssafy.smartstore.data.local.dao.OrderDetailDao_Impl;
import com.ssafy.smartstore.data.local.dao.ProductDao;
import com.ssafy.smartstore.data.local.dao.ProductDao_Impl;
import com.ssafy.smartstore.data.local.dao.StampDao;
import com.ssafy.smartstore.data.local.dao.StampDao_Impl;
import com.ssafy.smartstore.data.local.dao.UserDao;
import com.ssafy.smartstore.data.local.dao.UserDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class StoreDatabase_Impl extends StoreDatabase {
  private volatile UserDao _userDao;

  private volatile StampDao _stampDao;

  private volatile ProductDao _productDao;

  private volatile OrderDao _orderDao;

  private volatile OrderDetailDao _orderDetailDao;

  private volatile CommentDao _commentDao;

  private volatile NotiDao _notiDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(6) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `t_user` (`id` TEXT NOT NULL, `pass` TEXT NOT NULL, `stamps` INTEGER NOT NULL, `name` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `t_order` (`user_id` TEXT NOT NULL, `order_table` TEXT NOT NULL, `order_time` TEXT NOT NULL DEFAULT CURRENT_TIMESTAMP, `completed` INTEGER NOT NULL DEFAULT N, `o_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, FOREIGN KEY(`user_id`) REFERENCES `t_user`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `t_order_detail` (`order_id` INTEGER NOT NULL, `product_id` INTEGER NOT NULL, `quantity` INTEGER NOT NULL, `d_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, FOREIGN KEY(`product_id`) REFERENCES `t_product`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`order_id`) REFERENCES `t_order`(`o_id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `t_product` (`name` TEXT NOT NULL, `type` TEXT NOT NULL, `price` INTEGER NOT NULL, `img` TEXT NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `t_stamp` (`user_id` TEXT NOT NULL, `order_id` INTEGER NOT NULL, `quantity` INTEGER NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, FOREIGN KEY(`user_id`) REFERENCES `t_user`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`order_id`) REFERENCES `t_order`(`o_id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `t_comment` (`user_id` TEXT NOT NULL, `product_id` INTEGER NOT NULL, `rating` REAL NOT NULL, `comment` TEXT NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, FOREIGN KEY(`user_id`) REFERENCES `t_user`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`product_id`) REFERENCES `t_product`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `t_noti` (`u_id` TEXT NOT NULL, `data` TEXT NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '059d1966e74f5fcb8c225897d596b05a')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `t_user`");
        _db.execSQL("DROP TABLE IF EXISTS `t_order`");
        _db.execSQL("DROP TABLE IF EXISTS `t_order_detail`");
        _db.execSQL("DROP TABLE IF EXISTS `t_product`");
        _db.execSQL("DROP TABLE IF EXISTS `t_stamp`");
        _db.execSQL("DROP TABLE IF EXISTS `t_comment`");
        _db.execSQL("DROP TABLE IF EXISTS `t_noti`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        _db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsTUser = new HashMap<String, TableInfo.Column>(4);
        _columnsTUser.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTUser.put("pass", new TableInfo.Column("pass", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTUser.put("stamps", new TableInfo.Column("stamps", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTUser.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTUser = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTUser = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTUser = new TableInfo("t_user", _columnsTUser, _foreignKeysTUser, _indicesTUser);
        final TableInfo _existingTUser = TableInfo.read(_db, "t_user");
        if (! _infoTUser.equals(_existingTUser)) {
          return new RoomOpenHelper.ValidationResult(false, "t_user(com.ssafy.smartstore.data.local.dto.User).\n"
                  + " Expected:\n" + _infoTUser + "\n"
                  + " Found:\n" + _existingTUser);
        }
        final HashMap<String, TableInfo.Column> _columnsTOrder = new HashMap<String, TableInfo.Column>(5);
        _columnsTOrder.put("user_id", new TableInfo.Column("user_id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTOrder.put("order_table", new TableInfo.Column("order_table", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTOrder.put("order_time", new TableInfo.Column("order_time", "TEXT", true, 0, "CURRENT_TIMESTAMP", TableInfo.CREATED_FROM_ENTITY));
        _columnsTOrder.put("completed", new TableInfo.Column("completed", "INTEGER", true, 0, "N", TableInfo.CREATED_FROM_ENTITY));
        _columnsTOrder.put("o_id", new TableInfo.Column("o_id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTOrder = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysTOrder.add(new TableInfo.ForeignKey("t_user", "CASCADE", "NO ACTION",Arrays.asList("user_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesTOrder = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTOrder = new TableInfo("t_order", _columnsTOrder, _foreignKeysTOrder, _indicesTOrder);
        final TableInfo _existingTOrder = TableInfo.read(_db, "t_order");
        if (! _infoTOrder.equals(_existingTOrder)) {
          return new RoomOpenHelper.ValidationResult(false, "t_order(com.ssafy.smartstore.data.local.dto.Order).\n"
                  + " Expected:\n" + _infoTOrder + "\n"
                  + " Found:\n" + _existingTOrder);
        }
        final HashMap<String, TableInfo.Column> _columnsTOrderDetail = new HashMap<String, TableInfo.Column>(4);
        _columnsTOrderDetail.put("order_id", new TableInfo.Column("order_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTOrderDetail.put("product_id", new TableInfo.Column("product_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTOrderDetail.put("quantity", new TableInfo.Column("quantity", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTOrderDetail.put("d_id", new TableInfo.Column("d_id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTOrderDetail = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysTOrderDetail.add(new TableInfo.ForeignKey("t_product", "CASCADE", "NO ACTION",Arrays.asList("product_id"), Arrays.asList("id")));
        _foreignKeysTOrderDetail.add(new TableInfo.ForeignKey("t_order", "CASCADE", "NO ACTION",Arrays.asList("order_id"), Arrays.asList("o_id")));
        final HashSet<TableInfo.Index> _indicesTOrderDetail = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTOrderDetail = new TableInfo("t_order_detail", _columnsTOrderDetail, _foreignKeysTOrderDetail, _indicesTOrderDetail);
        final TableInfo _existingTOrderDetail = TableInfo.read(_db, "t_order_detail");
        if (! _infoTOrderDetail.equals(_existingTOrderDetail)) {
          return new RoomOpenHelper.ValidationResult(false, "t_order_detail(com.ssafy.smartstore.data.local.dto.OrderDetail).\n"
                  + " Expected:\n" + _infoTOrderDetail + "\n"
                  + " Found:\n" + _existingTOrderDetail);
        }
        final HashMap<String, TableInfo.Column> _columnsTProduct = new HashMap<String, TableInfo.Column>(5);
        _columnsTProduct.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTProduct.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTProduct.put("price", new TableInfo.Column("price", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTProduct.put("img", new TableInfo.Column("img", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTProduct.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTProduct = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTProduct = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTProduct = new TableInfo("t_product", _columnsTProduct, _foreignKeysTProduct, _indicesTProduct);
        final TableInfo _existingTProduct = TableInfo.read(_db, "t_product");
        if (! _infoTProduct.equals(_existingTProduct)) {
          return new RoomOpenHelper.ValidationResult(false, "t_product(com.ssafy.smartstore.data.local.dto.Product).\n"
                  + " Expected:\n" + _infoTProduct + "\n"
                  + " Found:\n" + _existingTProduct);
        }
        final HashMap<String, TableInfo.Column> _columnsTStamp = new HashMap<String, TableInfo.Column>(4);
        _columnsTStamp.put("user_id", new TableInfo.Column("user_id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTStamp.put("order_id", new TableInfo.Column("order_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTStamp.put("quantity", new TableInfo.Column("quantity", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTStamp.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTStamp = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysTStamp.add(new TableInfo.ForeignKey("t_user", "CASCADE", "NO ACTION",Arrays.asList("user_id"), Arrays.asList("id")));
        _foreignKeysTStamp.add(new TableInfo.ForeignKey("t_order", "CASCADE", "NO ACTION",Arrays.asList("order_id"), Arrays.asList("o_id")));
        final HashSet<TableInfo.Index> _indicesTStamp = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTStamp = new TableInfo("t_stamp", _columnsTStamp, _foreignKeysTStamp, _indicesTStamp);
        final TableInfo _existingTStamp = TableInfo.read(_db, "t_stamp");
        if (! _infoTStamp.equals(_existingTStamp)) {
          return new RoomOpenHelper.ValidationResult(false, "t_stamp(com.ssafy.smartstore.data.local.dto.Stamp).\n"
                  + " Expected:\n" + _infoTStamp + "\n"
                  + " Found:\n" + _existingTStamp);
        }
        final HashMap<String, TableInfo.Column> _columnsTComment = new HashMap<String, TableInfo.Column>(5);
        _columnsTComment.put("user_id", new TableInfo.Column("user_id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTComment.put("product_id", new TableInfo.Column("product_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTComment.put("rating", new TableInfo.Column("rating", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTComment.put("comment", new TableInfo.Column("comment", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTComment.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTComment = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysTComment.add(new TableInfo.ForeignKey("t_user", "CASCADE", "NO ACTION",Arrays.asList("user_id"), Arrays.asList("id")));
        _foreignKeysTComment.add(new TableInfo.ForeignKey("t_product", "CASCADE", "NO ACTION",Arrays.asList("product_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesTComment = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTComment = new TableInfo("t_comment", _columnsTComment, _foreignKeysTComment, _indicesTComment);
        final TableInfo _existingTComment = TableInfo.read(_db, "t_comment");
        if (! _infoTComment.equals(_existingTComment)) {
          return new RoomOpenHelper.ValidationResult(false, "t_comment(com.ssafy.smartstore.data.local.dto.Comment).\n"
                  + " Expected:\n" + _infoTComment + "\n"
                  + " Found:\n" + _existingTComment);
        }
        final HashMap<String, TableInfo.Column> _columnsTNoti = new HashMap<String, TableInfo.Column>(3);
        _columnsTNoti.put("u_id", new TableInfo.Column("u_id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTNoti.put("data", new TableInfo.Column("data", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTNoti.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTNoti = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTNoti = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTNoti = new TableInfo("t_noti", _columnsTNoti, _foreignKeysTNoti, _indicesTNoti);
        final TableInfo _existingTNoti = TableInfo.read(_db, "t_noti");
        if (! _infoTNoti.equals(_existingTNoti)) {
          return new RoomOpenHelper.ValidationResult(false, "t_noti(com.ssafy.smartstore.data.local.dto.Noti).\n"
                  + " Expected:\n" + _infoTNoti + "\n"
                  + " Found:\n" + _existingTNoti);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "059d1966e74f5fcb8c225897d596b05a", "3aaa68f93f46201fc9344989fa013f41");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "t_user","t_order","t_order_detail","t_product","t_stamp","t_comment","t_noti");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `t_user`");
      _db.execSQL("DELETE FROM `t_order`");
      _db.execSQL("DELETE FROM `t_order_detail`");
      _db.execSQL("DELETE FROM `t_product`");
      _db.execSQL("DELETE FROM `t_stamp`");
      _db.execSQL("DELETE FROM `t_comment`");
      _db.execSQL("DELETE FROM `t_noti`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(UserDao.class, UserDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(StampDao.class, StampDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ProductDao.class, ProductDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(OrderDao.class, OrderDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(OrderDetailDao.class, OrderDetailDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(CommentDao.class, CommentDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(NotiDao.class, NotiDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public UserDao userDao() {
    if (_userDao != null) {
      return _userDao;
    } else {
      synchronized(this) {
        if(_userDao == null) {
          _userDao = new UserDao_Impl(this);
        }
        return _userDao;
      }
    }
  }

  @Override
  public StampDao stampDao() {
    if (_stampDao != null) {
      return _stampDao;
    } else {
      synchronized(this) {
        if(_stampDao == null) {
          _stampDao = new StampDao_Impl(this);
        }
        return _stampDao;
      }
    }
  }

  @Override
  public ProductDao productDao() {
    if (_productDao != null) {
      return _productDao;
    } else {
      synchronized(this) {
        if(_productDao == null) {
          _productDao = new ProductDao_Impl(this);
        }
        return _productDao;
      }
    }
  }

  @Override
  public OrderDao orderDao() {
    if (_orderDao != null) {
      return _orderDao;
    } else {
      synchronized(this) {
        if(_orderDao == null) {
          _orderDao = new OrderDao_Impl(this);
        }
        return _orderDao;
      }
    }
  }

  @Override
  public OrderDetailDao orderDetailDao() {
    if (_orderDetailDao != null) {
      return _orderDetailDao;
    } else {
      synchronized(this) {
        if(_orderDetailDao == null) {
          _orderDetailDao = new OrderDetailDao_Impl(this);
        }
        return _orderDetailDao;
      }
    }
  }

  @Override
  public CommentDao commentDao() {
    if (_commentDao != null) {
      return _commentDao;
    } else {
      synchronized(this) {
        if(_commentDao == null) {
          _commentDao = new CommentDao_Impl(this);
        }
        return _commentDao;
      }
    }
  }

  @Override
  public NotiDao notiDao() {
    if (_notiDao != null) {
      return _notiDao;
    } else {
      synchronized(this) {
        if(_notiDao == null) {
          _notiDao = new NotiDao_Impl(this);
        }
        return _notiDao;
      }
    }
  }
}
