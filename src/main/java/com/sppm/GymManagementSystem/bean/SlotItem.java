      package com.sppm.GymManagementSystem.bean;
    import  com.sppm.GymManagementSystem.bean.SlotItemEmbed;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


@Entity
public class SlotItem {
	@EmbeddedId
	private SlotItemEmbed EmbeddedId;
	private Integer seatBooked;
	public SlotItem() {
		super();
		seatBooked=0;
	}

	public SlotItemEmbed getEmbeddedId() {
		return EmbeddedId;
	}
	public void setEmbeddedId(SlotItemEmbed EmbeddedId) {
		this.EmbeddedId = EmbeddedId;
	}
	public Integer getSeatBooked() {
		return seatBooked;
	}
	public void setSeatBooked(Integer seatBooked) {
		this.seatBooked = seatBooked;
	}
}
	
	
	
	