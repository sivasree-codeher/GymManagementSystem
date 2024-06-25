package com.sppm.GymManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sppm.GymManagementSystem.bean.GymItem;
import com.sppm.GymManagementSystem.bean.Slot;
import com.sppm.GymManagementSystem.dao.GymItemDao;
import com.sppm.GymManagementSystem.dao.SlotDao;

@RestController
public class GymController {
	
	@Autowired
	private GymItemDao gymItemDao;
	
	@Autowired
	private SlotDao slotDao;
	
	
	@GetMapping("/index")
	public ModelAndView showIndex() {
		return new ModelAndView("index");
	}
	
	@GetMapping("/queries")
	public ModelAndView showQueries() {
		return new ModelAndView("queries");
	}
	
	@GetMapping("/gymServiceEntryPage")
	public ModelAndView showGymServicePage() {
		GymItem gymItem = new GymItem();
		Long newId = gymItemDao.generateItemId();
		gymItem.setItemId(newId);
		ModelAndView mv = new ModelAndView("gymServiceEntryPage");
		mv.addObject("itemRecord",gymItem);
		return mv;
	}
	
	@PostMapping("/gymService")
	public ModelAndView saveGymService(@ModelAttribute("itemRecord") GymItem gymItem) {
		gymItemDao.saveNewItem(gymItem);
		return new ModelAndView("index");
	}
	
	@GetMapping("/gymServiceReport")
	public ModelAndView showGymServiceTable() {
		List<GymItem> itemList = gymItemDao.displayAllItems();
		ModelAndView mv = new ModelAndView("gymServiceReport");
		mv.addObject("itemList",itemList);
		return mv;
	}
	
	@GetMapping("/slotBooking")
	public ModelAndView showGymSlots() {
		return new ModelAndView("slotBooking");
		
	}
	
	/* Gym Slot Mappings*/
	
	@GetMapping("/gymSlotEntryPage")
	public ModelAndView showSlotEntryPage() {
		Slot slot = new Slot();
		Long newId = slotDao.generateSlotId();
		slot.setSlotId(newId);
		ModelAndView mv= new ModelAndView("gymSlotEntryPage");
		mv.addObject("itemRecord", slot);
		return mv;
	}
	
	@PostMapping("/gymSlot")
	public ModelAndView saveGymSlot(@ModelAttribute("itemRecord") Slot slot) {
		slotDao.saveNewItem(slot);
		return new ModelAndView("index");
	}
	
	@GetMapping("/gymSlotReport")
	public ModelAndView showGymSlotTable() {
		List<Slot> itemList = slotDao.displayAllSlot();
		ModelAndView mv = new ModelAndView("gymSlotReport");
		mv.addObject("itemList",itemList);
		 return mv;
	}
}
