package com.ofo.restaurantservice.service;

import javax.validation.Valid;

import com.ofo.restaurantservice.model.Restaurant;

public interface RestaurantService {

	Restaurant getRestaurantById(String restaurantId);

	Restaurant saveRestaurant(Restaurant restaurant);

	Restaurant updateRestaurant(Restaurant restaurant);

}
