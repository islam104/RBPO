package com.hrRecruting.demo.Controller;

import com.hrRecruting.demo.Entity.Offer;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/offers")
public class OfferController {
    private List<Offer> offers = new ArrayList<>();

    @PostMapping("/create")
    public Offer createOffer(@RequestBody Offer offer) {

        offer.setCreatedAt(LocalDateTime.now());
        offers.add(offer);
        return offer;
    }

    @GetMapping("/getAll")
    public List<Offer> getAllOffers() {
        return offers;
    }

    @GetMapping("/{id}")
    public Offer getOffer(@PathVariable Long id) {
        for (Offer offer : offers) {
            if (offer.getId().equals(id)) {
                return offer;
            }
        }
        return null;
    }

    @PutMapping("/{id}")
    public Offer updateOffer(@PathVariable Long id, @RequestBody Offer offer) {
        for (int i = 0; i < offers.size(); i++) {
            if (offers.get(i).getId().equals(id)) {
                offer.setId(id);
                offers.set(i, offer);
                return offer;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteOffer(@PathVariable Long id) {
        offers.removeIf(o -> o.getId().equals(id));
    }

}
