package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Emp;
import utils.DBUtil;

public class EmpDao {
	DBUtil dbu=new DBUtil();
	// 查找所有员工
	public List<Emp> findAll() {
		List<Emp> empList = new ArrayList<Emp>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = dbu.getConnection();
			String sql = "SELECT id,name,salary,age FROM emp";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Emp emp = new Emp();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setAge(rs.getInt("age"));
				empList.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				dbu.closeConnection(con, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return empList;
	}

	public void addEmp(Emp emp){
		Connection con=null;
		PreparedStatement ps=null;
		String sql="INSERT INTO emp(name,salary,age) values(?,?,?)";
		try {
			
			con = dbu.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, emp.getName());
			ps.setDouble(2, emp.getSalary());
			ps.setInt(3, emp.getAge());
			int flag=ps.executeUpdate();
			if(flag>0) {
				System.out.println("添加员工成功！");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				dbu.closeConnection(con, ps, null);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}		
	}
	public void deleteEmp(int id) {
		Connection con=null;
		PreparedStatement ps=null;
		String sql="DELETE FROM emp WHERE id=?";
		try {
			con=dbu.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			int flag=ps.executeUpdate();
			if(flag>0) {
				System.out.println("删除员工成功！");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				dbu.closeConnection(con, ps, null);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public Emp loadEmp(int id){
		Emp emp = null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			con=dbu.getConnection();
			String sql="select * from emp where id =?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()){
				emp=new Emp();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setAge(rs.getInt("age"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				dbu.closeConnection(con, ps, null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return emp;
	}	

	public void updateEmp(Emp emp) {
		Connection con=null;
		PreparedStatement ps=null;
		String sql="UPDATE emp SET name=?,salary=?,age=? where id=?";
		try {
			con=dbu.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, emp.getName());
			ps.setDouble(2, emp.getSalary());
			ps.setInt(3, emp.getAge());
			ps.setInt(4, emp.getId());
			int flag=ps.executeUpdate();
			if(flag>0) {
				System.out.println("更新成功！");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				dbu.closeConnection(con, ps, null);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

}






