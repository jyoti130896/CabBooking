package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.Exception.RouteNotFoundException;
import com.cg.dto.Route;
import com.cg.repo.RouteRepo;

public class RouteserviceImpl implements RouteService {
	@Autowired
	private RouteRepo repo;
	@Override
	public Route addRoute(Route route) {
		return repo.save(route);
	}

	@Override
	public Route fetchRouteById(int routeId) throws RouteNotFoundException {
		try {
			Route route= repo.findById(routeId).get();
			if(route==null)
				throw new RouteNotFoundException("No route with such Route Id exists");
			return route;
		} catch (Exception e) {
			throw new RouteNotFoundException("No Menu Item for Item Id: "+routeId);
		}
	}

	@Override
	public double fetchDistanceBySourceAndDestination(String source, String destination) {
			double distance= repo.getDistanceBySourceAndDestination(source, destination);
			return distance;
	}

	@Override
	public List<Route> fetchAllRoute() {
		return repo.findAll();
	}

}
