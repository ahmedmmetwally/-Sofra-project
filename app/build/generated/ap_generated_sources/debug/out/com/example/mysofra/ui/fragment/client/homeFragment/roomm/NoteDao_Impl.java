package com.example.mysofra.ui.fragment.client.homeFragment.roomm;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.mysofra.data.model.Note;
import java.lang.Exception;
import java.lang.Float;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class NoteDao_Impl implements NoteDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Note> __insertionAdapterOfNote;

  private final EntityDeletionOrUpdateAdapter<Note> __deletionAdapterOfNote;

  private final EntityDeletionOrUpdateAdapter<Note> __updateAdapterOfNote;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public NoteDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfNote = new EntityInsertionAdapter<Note>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `note_table` (`id`,`restaurant_id`,`photo_url`,`restaurantName`,`itmeName`,`price`,`specialOrder`,`quantity`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Note value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getRestaurant_id());
        if (value.getPhoto_url() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPhoto_url());
        }
        if (value.getRestaurantName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getRestaurantName());
        }
        if (value.getItmeName() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getItmeName());
        }
        if (value.getPrice() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindDouble(6, value.getPrice());
        }
        if (value.getSpecialOrder() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getSpecialOrder());
        }
        stmt.bindLong(8, value.getQuantity());
      }
    };
    this.__deletionAdapterOfNote = new EntityDeletionOrUpdateAdapter<Note>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `note_table` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Note value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfNote = new EntityDeletionOrUpdateAdapter<Note>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `note_table` SET `id` = ?,`restaurant_id` = ?,`photo_url` = ?,`restaurantName` = ?,`itmeName` = ?,`price` = ?,`specialOrder` = ?,`quantity` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Note value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getRestaurant_id());
        if (value.getPhoto_url() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPhoto_url());
        }
        if (value.getRestaurantName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getRestaurantName());
        }
        if (value.getItmeName() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getItmeName());
        }
        if (value.getPrice() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindDouble(6, value.getPrice());
        }
        if (value.getSpecialOrder() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getSpecialOrder());
        }
        stmt.bindLong(8, value.getQuantity());
        stmt.bindLong(9, value.getId());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM note_table";
        return _query;
      }
    };
  }

  @Override
  public void insert(final Note note) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfNote.insert(note);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Note note) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfNote.handle(note);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Note note) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfNote.handle(note);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public LiveData<List<Note>> getAllNotes() {
    final String _sql = "SELECT * FROM note_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"note_table"}, false, new Callable<List<Note>>() {
      @Override
      public List<Note> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfRestaurantId = CursorUtil.getColumnIndexOrThrow(_cursor, "restaurant_id");
          final int _cursorIndexOfPhotoUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "photo_url");
          final int _cursorIndexOfRestaurantName = CursorUtil.getColumnIndexOrThrow(_cursor, "restaurantName");
          final int _cursorIndexOfItmeName = CursorUtil.getColumnIndexOrThrow(_cursor, "itmeName");
          final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
          final int _cursorIndexOfSpecialOrder = CursorUtil.getColumnIndexOrThrow(_cursor, "specialOrder");
          final int _cursorIndexOfQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "quantity");
          final List<Note> _result = new ArrayList<Note>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Note _item;
            final int _tmpRestaurant_id;
            _tmpRestaurant_id = _cursor.getInt(_cursorIndexOfRestaurantId);
            final String _tmpPhoto_url;
            _tmpPhoto_url = _cursor.getString(_cursorIndexOfPhotoUrl);
            final String _tmpRestaurantName;
            _tmpRestaurantName = _cursor.getString(_cursorIndexOfRestaurantName);
            final String _tmpItmeName;
            _tmpItmeName = _cursor.getString(_cursorIndexOfItmeName);
            final Float _tmpPrice;
            if (_cursor.isNull(_cursorIndexOfPrice)) {
              _tmpPrice = null;
            } else {
              _tmpPrice = _cursor.getFloat(_cursorIndexOfPrice);
            }
            final String _tmpSpecialOrder;
            _tmpSpecialOrder = _cursor.getString(_cursorIndexOfSpecialOrder);
            final int _tmpQuantity;
            _tmpQuantity = _cursor.getInt(_cursorIndexOfQuantity);
            _item = new Note(_tmpRestaurant_id,_tmpPhoto_url,_tmpRestaurantName,_tmpItmeName,_tmpPrice,_tmpSpecialOrder,_tmpQuantity);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
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
}
