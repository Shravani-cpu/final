package dao;

import java.util.List;

import dto.Item;

public interface ItemDAO {
	void addItem(Item item);
	List<Item> viewItems(String status);
}