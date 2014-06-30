package org.realrest.domain.repository.impl;

import org.realrest.domain.City;
import org.realrest.domain.Hotel;
import org.realrest.domain.Room;
import org.realrest.domain.repository.CityRepository;
import org.realrest.domain.repository.HotelRepository;
import org.realrest.domain.repository.RoomRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * @author volodymyr.tsukur
 */
@ApplicationScoped
public class MockedDataLoader {

    @Inject
    private HotelRepository hotelRepository;

    @Inject
    private CityRepository cityRepository;

    @Inject
    private RoomRepository roomRepository;

    public void load() {
        saveCitiesAndHotels();
    }

    private void saveCitiesAndHotels() {
        final City lviv = new City();
        lviv.setName("Lviv");
        cityRepository.create(lviv);

        final City kyiv = new City();
        kyiv.setName("Kyiv");
        cityRepository.create(kyiv);

        final Hotel vintageBoutique = new Hotel();
        vintageBoutique.setName("Vintage Boutique Hotel");
        vintageBoutique.setCity(lviv);
        vintageBoutique.getRooms().add(roomRepository.create(new Room(Room.Type.SINGLE, 500)));
        vintageBoutique.getRooms().add(roomRepository.create(new Room(Room.Type.DOUBLE, 800)));
        hotelRepository.create(vintageBoutique);

        final Hotel nobilis = new Hotel();
        nobilis.setName("Nobilis");
        nobilis.setCity(lviv);
        nobilis.getRooms().add(roomRepository.create(new Room(Room.Type.JUNIOR_SUITE, 2500)));
        nobilis.getRooms().add(roomRepository.create(new Room(Room.Type.SUITE, 4500)));
        hotelRepository.create(nobilis);

        final Hotel premierPalace = new Hotel();
        premierPalace.setName("Premier Palace");
        premierPalace.setCity(kyiv);
        premierPalace.getRooms().add(roomRepository.create(new Room(Room.Type.SINGLE, 1000)));
        premierPalace.getRooms().add(roomRepository.create(new Room(Room.Type.DOUBLE, 1500)));
        hotelRepository.create(premierPalace);

        final Hotel fairmontGrandHotelKyiv = new Hotel();
        fairmontGrandHotelKyiv.setName("Fairmont");
        fairmontGrandHotelKyiv.setCity(kyiv);
        fairmontGrandHotelKyiv.getRooms().add(roomRepository.create(new Room(Room.Type.DOUBLE, 3000)));
        fairmontGrandHotelKyiv.getRooms().add(roomRepository.create(new Room(Room.Type.KING, 6000)));
        hotelRepository.create(fairmontGrandHotelKyiv);
    }

}
