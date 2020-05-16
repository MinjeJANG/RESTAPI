package mj.project.eatgo.application;

import mj.project.eatgo.domain.Region;
import mj.project.eatgo.domain.RegionRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

public class RegionServiceTests {

    private RegionService regionService;

    @Mock
    private RegionRepository regionRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        regionService = new RegionService(regionRepository);
    }

    @Test
    public void getRegions() {

        List<Region> mockRegions = new ArrayList<>();
        mockRegions.add(Region.builder().name("Seoul").build());

        given(regionRepository.findAll()).willReturn(mockRegions);
        List<Region> regions = regionService.getRegions();

        Region region = regions.get(0);
        assertThat(region.getName(), is("Seoul"));
    }

}