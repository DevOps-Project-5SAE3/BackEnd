package tn.esprit.devops_project.services;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.devops_project.entities.ActivitySector;
import tn.esprit.devops_project.repositories.ActivitySectorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ActivitySectorImplTest {


    @Mock
    private ActivitySectorRepository activitySectorRepository;

    @InjectMocks
    private ActivitySectorImpl activitySectorService;

    @Test
    void retrieveAllActivitySectors() {
        List<ActivitySector> activitySectors = new ArrayList<>();
        when(activitySectorRepository.findAll()).thenReturn(activitySectors);
        List<ActivitySector> result = activitySectorService.retrieveAllActivitySectors();
        assertEquals(activitySectors, result);
    }

    @Test
    void addActivitySector() {
        ActivitySector activitySector = new ActivitySector();
        when(activitySectorRepository.save(activitySector)).thenReturn(activitySector);
        ActivitySector result = activitySectorService.addActivitySector(activitySector);
        assertEquals(activitySector, result);
    }

    @Test
    void deleteActivitySector() {
        Long id = 1L;
        doNothing().when(activitySectorRepository).deleteById(id);
        activitySectorService.deleteActivitySector(id);
        verify(activitySectorRepository, times(1)).deleteById(id);
    }

    @Test
    void updateActivitySector() {
        ActivitySector activitySector = new ActivitySector();
        when(activitySectorRepository.save(activitySector)).thenReturn(activitySector);
        ActivitySector result = activitySectorService.updateActivitySector(activitySector);
        assertEquals(activitySector, result);
    }

    @Test
    void retrieveActivitySector() {
        Long id = 1L;
        ActivitySector activitySector = new ActivitySector();
        when(activitySectorRepository.findById(id)).thenReturn(Optional.of(activitySector));
        ActivitySector result = activitySectorService.retrieveActivitySector(id);
        assertEquals(activitySector, result);
    }
}
