package com.jsp.service;

import com.jsp.dao.VehicleDao;
import com.jsp.dto.Vehicle;

public class VehicleServices {
	VehicleDao vehicleDao = new VehicleDao();

	public Vehicle createVehicle(Vehicle vehicle) {
		return vehicleDao.createVehicle(vehicle);
	}

	public Vehicle getVehicleById(int id) {
		return vehicleDao.getVehicleById(id);
	}

	public Vehicle deleteVehicleById(int id) {
		return vehicleDao.deleteVehicleById(id);
	}

	public Vehicle updateVehicleById(int id, String name, String brand, int vehicle_no) {

		return vehicleDao.updateVehicleById(id, name, brand, vehicle_no);
	}
}