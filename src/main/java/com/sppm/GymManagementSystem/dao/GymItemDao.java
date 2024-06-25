package com.sppm.GymManagementSystem.dao;
import java.util.List;

import com.sppm.GymManagementSystem.bean.GymItem;
public interface GymItemDao {
  public void saveNewItem(GymItem gymItem);
  public List<GymItem> displayAllItems();
  public GymItem findItemById(Long id);
  public Long generateItemId();
}
