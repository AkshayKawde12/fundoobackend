package com.bridgelabz.fundoo.label.service;





import java.util.List;

import com.bridgelabz.fundoo.label.dto.LabelDto;
import com.bridgelabz.fundoo.label.model.LabelModel;
import com.bridgelabz.fundoo.response.Response;

public interface LabelService {

	Response createLabel(LabelDto labelDto, String token);

	Response deleteLabel(long labelId, String token);

//	Response updateLabel(Labeldto labelDto, String token);

	 List<LabelModel> getAllLabel(String token);

	Response updateLabel(Long labelId, LabelDto labelDto, String token);

	
	

	

}
