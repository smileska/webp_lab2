package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Event;
import mk.ukim.finki.wp.lab.repository.EventRepository;
import mk.ukim.finki.wp.lab.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> listAll() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> searchEvents(String text, Double minRating) {
        return eventRepository.searchEvents(text, minRating);
    }

    @Override
    public Optional<Event> save(String name, String description, Double popularityScore, Long locationId) {
        return eventRepository.save(name, description, popularityScore, locationId);
    }

    @Override
    public Optional<Event> findById(Long id) {
        return  eventRepository.findById(id);
    }

    @Override
    public Optional<Event> update(Long id, String name, String description, Double popularityScore, Long locationId) {
        return eventRepository.update(id, name, description, popularityScore, locationId);
    }

    @Override
    public Optional<Event> delete(Long id) {
        return eventRepository.delete(id);
    }

    @Override
    public Optional<Event> likeEvent(Long id) {
        return eventRepository.getPoints(id);
    }
}
