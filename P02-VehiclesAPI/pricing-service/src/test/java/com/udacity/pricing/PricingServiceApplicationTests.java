package com.udacity.pricing;

import com.udacity.pricing.api.PricingController;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import org.junit.jupiter.api.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.http.MediaType;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PricingController.class)
public class PricingServiceApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	public void contextLoads() {
	}

	@Test
	public void getPriceByVehicleId() throws Exception {
		int vehicleId = 2;
		mockMvc.perform(get("/services/price?vehicleId=" + vehicleId))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void getPriceByInvalidVehicleId() throws Exception {
		int vehicleId = 21;
		mockMvc.perform(get("/services/price?vehicleId=" + vehicleId))
				.andExpect(status().isNotFound());
	}

}
