package service.impl;

import entity.ConfigPoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ConfigPointRepository;
import service.ConfigPointService;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@Slf4j
public class ConfigPointServiceImpl implements ConfigPointService {
    @Autowired
    private ConfigPointRepository configPointRepository;

    @Override
    @Transactional
    public ConfigPoint setConfig(Double pointOfConversion) {
        List<ConfigPoint> datas = configPointRepository.findAll();
        ConfigPoint configPoint = new ConfigPoint();
        if(!datas.isEmpty()){
            configPoint = datas.get(0);
            configPoint.setConfigOld(configPoint.getConfig());
        }
        configPoint.setConfig(pointOfConversion);
        configPoint.setCreateOn(LocalDateTime.now());
        configPointRepository.save(configPoint);
        return configPoint;
    }
}
