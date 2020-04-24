package service;

import entity.ConfigPoint;
import org.springframework.stereotype.Service;

@Service
public interface ConfigPointService {
    ConfigPoint setConfig(Double pointOfConversion);
}
