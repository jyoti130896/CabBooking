package com.cg.service;

import java.util.List;

import com.cg.Exception.RouteNotFoundException;
import com.cg.dto.Route;

public interface RouteService {
Route addRoute(Route route);
	
	Route fetchRouteById(double routeId) throws RouteNotFoundException;
	
	Object fetchDistanceBySourceAndDestination(String source, String destination);
	
	List<Route> fetchAllRoute();
	
}
