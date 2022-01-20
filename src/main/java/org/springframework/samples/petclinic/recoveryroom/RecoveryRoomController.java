package org.springframework.samples.petclinic.recoveryroom;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RecoveryRoomController {
	
	@Autowired
	private RecoveryRoomService rRService;
	
	private static final String VIEWS_RECOVERYROOM_CREATE_OR_UPDATE_FORM = "recoveryroom/createOrUpdateRecoveryRoomForm";
    
	
	@GetMapping(value = "/recoveryroom/create")
	public String initCreationForm(Map<String, Object> model) {
		RecoveryRoom recoveryRoom = new RecoveryRoom();
		model.put("recoveryRoom", recoveryRoom);
		model.put("recoveryRoomType", rRService.getAllRecoveryRoomTypes());
		return VIEWS_RECOVERYROOM_CREATE_OR_UPDATE_FORM;
	}

	
	@PostMapping(value = "/recoveryroom/create")
	public String processCreationForm(@Valid RecoveryRoom recoveryRoom, BindingResult result, ModelMap modelMap) {
		String view = "welcome";
		if (result.hasErrors()) {
			modelMap.addAttribute("recoveryRoom", recoveryRoom);
			modelMap.addAttribute("recoveryRoomType", rRService.getAllRecoveryRoomTypes());
			return VIEWS_RECOVERYROOM_CREATE_OR_UPDATE_FORM;
		}
		else {
			//creating recoveryRoom
			this.rRService.save(recoveryRoom);
			modelMap.addAttribute("message", "Product successfully saved!");
		}
		return view;
	}
}
