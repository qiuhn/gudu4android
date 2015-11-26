package com.qiuhn.gudu.db;

import java.util.ArrayList;
import java.util.List;

import com.qiuhn.gudu.common.db.DbConstants;
import com.qiuhn.gudu.common.GuduApplication;
import com.qiuhn.gudu.domain.Department;
import com.qiuhn.gudu.domain.School;
import com.qiuhn.gudu.provider.constants.DepartmentConstants;
import com.qiuhn.gudu.provider.constants.SchoolConstants;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class SchoolDaoHelper {

    public static String TABLE_NAME_SCHOOL = "t_school";
    public static String TABLE_NAME_DEPARTMENT = "t_department";

    /**
     * 根据关键字过滤出学校列表
     *
     * @param str
     * @return
     */
    public static List<School> querySchools(String str) {
        String[] columns = new String[]{SchoolConstants.id,
                SchoolConstants.name, SchoolConstants.pinyin,
                SchoolConstants.py, SchoolConstants.rank};
        String selection = SchoolConstants.name + " like ? or "
                + SchoolConstants.pinyin + " like ? or " + SchoolConstants.py
                + " like ?";
        String[] selectionArgs = new String[]{"%" + str + "%",
                "%" + str + "%", "%" + str + "%"};
        Cursor c = getDb().query(TABLE_NAME_SCHOOL, columns, selection,
                selectionArgs, null, null, SchoolConstants.pinyin + " asc ");
        List<School> list = new ArrayList<School>();
        if (c != null) {
            while (c.moveToNext()) {
                int id = c.getInt(0);
                String name = c.getString(1);
                String pinyin = c.getString(2);
                String py = c.getString(3);
                int rank = c.getInt(4);
                School school = new School(id, name, pinyin, py, rank);
                list.add(school);
            }
            c.close();
        }
        return list;
    }

    /**
     * 根据关键字过滤出院系列表
     *
     * @param str
     * @param schoolId
     * @return
     */
    public static List<Department> queryDepartments(String str, int schoolId) {
        String[] columns = new String[]{DepartmentConstants.id,
                DepartmentConstants.name};
        String selection = DepartmentConstants.name + " like ?";
        String[] selectionArgs = new String[]{"%" + str + "%"};
        Cursor c = getDb().query(TABLE_NAME_DEPARTMENT, columns, selection,
                selectionArgs, null, null, DepartmentConstants.name + " asc ");
        List<Department> list = new ArrayList<Department>();
        if (c != null) {
            while (c.moveToNext()) {
                int id = c.getInt(0);
                String name = c.getString(1);
                Department department = new Department(id, name, schoolId);
                list.add(department);
            }
            c.close();
        }
        return list;
    }

    public static SQLiteDatabase getDb() {
        return GuduApplication.getInstance().getSQLiteDatabase(
                DbConstants.DB_NAME_SCHOOL);
    }

    /**
     * 根据id获取学校
     *
     * @param schoolId
     * @return
     */
    public static School getSchool(int schoolId) {
        String[] columns = new String[]{SchoolConstants.id,
                SchoolConstants.name, SchoolConstants.pinyin,
                SchoolConstants.py, SchoolConstants.rank};
        String selection = SchoolConstants.id + " = ?";
        String[] selectionArgs = new String[]{schoolId + ""};
        Cursor c = getDb().query(TABLE_NAME_SCHOOL, columns, selection,
                selectionArgs, null, null, null);
        if (c != null && c.moveToNext()) {
            int id = c.getInt(0);
            String name = c.getString(1);
            String pinyin = c.getString(2);
            String py = c.getString(3);
            int rank = c.getInt(4);
            School school = new School(id, name, pinyin, py, rank);
            c.close();
            return school;
        }
        return null;
    }

    /**
     * 根据ID查询院系
     *
     * @param context
     * @param str
     * @param departmentId
     * @param schoolId
     * @return
     */
    public static Department getDepartment(long departmentId, int schoolId) {
        String[] columns = new String[]{DepartmentConstants.id,
                DepartmentConstants.name};
        String selection = DepartmentConstants.name + " = ?";
        String[] selectionArgs = new String[]{departmentId + ""};
        Cursor c = getDb().query(TABLE_NAME_DEPARTMENT, columns, selection,
                selectionArgs, null, null, DepartmentConstants.name + " asc ");
        if (c != null && c.moveToNext()) {
            int id = c.getInt(0);
            String name = c.getString(1);
            Department department = new Department(id, name, schoolId);
            c.close();
            return department;
        }
        return null;
    }

}
