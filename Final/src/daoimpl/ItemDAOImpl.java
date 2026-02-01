package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.ItemDAO;
import dto.Item;
import util.DBConnection;

public class ItemDAOImpl implements ItemDAO{
	public void addItem(Item item) {
		try {
			Connection con=DBConnection.getConnection();
			String sql="INSERT INTO item(name,place,status)VALUES(?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, item.getName());
			ps.setString(2, item.getPlace());	
			ps.setString(3, item.getStatus());
			ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Item> viewItems(String status) {
		List<Item>list=new ArrayList<>();
		try {
			Connection con=DBConnection.getConnection();
			String sql="SELECT * FROM item WHERE UPPER(status)=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, status);;
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Item i=new Item();
				i.setId(rs.getInt("id"));
				i.setName(rs.getString("name"));
				i.setPlace(rs.getString("place"));
				i.setStatus(rs.getString("status"));
				list.add(i);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
