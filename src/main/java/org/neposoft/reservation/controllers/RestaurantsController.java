package org.neposoft.reservation.controllers;

import org.neposoft.reservation.domain.restaurant.Restaurant;
import org.neposoft.reservation.domain.restaurant.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by mrdezzods on 28/02/16.
 */
@Controller
public class RestaurantsController {

    @Autowired
    RestaurantService restaurantService;

    @RequestMapping(value = "/restaurants")
    @ResponseBody
    public List<Restaurant> paginate() {
        List<Restaurant> restaurants = restaurantService.getAll();
        System.out.println(restaurants.get(0).getReservations().get(0).getClient().getName());
        return restaurants;
    }

    @RequestMapping(value = "/restaurants/{slug}")
    public ModelAndView show(@PathVariable String slug) {
        ModelAndView mv = new ModelAndView("reservation");
        mv.addObject("restaurant", restaurantService.findBySlug(slug));
        return mv;
    }

}
