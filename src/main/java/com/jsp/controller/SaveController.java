package com.jsp.controller;

import com.jsp.dto.Chasis;
import com.jsp.dto.Vehicle;
import com.jsp.service.ChasisServices;
import com.jsp.service.VehicleServices;

public class SaveController {
	public static void main(String[] args) {
		VehicleServices vehicleServices = new VehicleServices();
		ChasisServices chasisServices = new ChasisServices();
		Vehicle vehicle = new Vehicle();
		Chasis chasis = new Chasis();

		chasis.setOwner_name("sameer");
		chasis.setChasis_no(35782);
		chasis.setVehicle(vehicle);
		chasisServices.createChasis(chasis);

		vehicle.setName("Maruti");
		vehicle.setBrand("Tata");
		vehicle.setVehicle_no(56272);
		vehicle.setChasis(chasis);
		vehicleServices.createVehicle(vehicle);
	}
}