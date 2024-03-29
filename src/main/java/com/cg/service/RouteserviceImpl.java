package com.cg.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.Exception.RouteNotFoundException;
import com.cg.dto.Route;
import com.cg.repo.RouteRepo;
@Service
@Transactional
public class RouteserviceImpl implements RouteService {
	@Autowired
	private RouteRepo repo;
	@Override
	public Route addRoute(Route route) {
		return repo.save(route);
	}

	@Override
	public Route fetchRouteById(double routeId) throws RouteNotFoundException {
		try {
			Route route= repo.findById(routeId).get();
			if(route==null)
				throw new RouteNotFoundException("No route with such Route Id exists");
			return route;
		} catch (Exception e) {
			throw new RouteNotFoundException("No Route for Route Id: "+routeId);
		}
	}

	@Override
	public Object fetchDistanceBySourceAndDestination(String source, String destination) {
			Object distance= repo.getDistanceBySourceAndDestination(source, destination);
			return distance;
	}

	@Override
	public List<Route> fetchAllRoute() {
		return repo.findAll();
	}

}
