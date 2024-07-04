package com.sppm.GymManagementSystem.dao;

import com.sppm.GymManagementSystem.bean.SlotItem;
import com.sppm.GymManagementSystem.bean.SlotItemEmbed;
import java.util.Set;

public interface SlotItemDao {
	
	public void save(SlotItem slotitem);
	public Integer findSeatBookedById(SlotItemEmbed id);
	public Set<SlotItemEmbed> findAllEmbeds();
}