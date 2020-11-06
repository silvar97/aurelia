package com.discord.aurelia.Service;

import java.util.Optional;

import com.discord.aurelia.model.Warning;
import com.discord.aurelia.model.WarningPK;
import com.discord.aurelia.repository.WarningRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(2)
@CacheConfig(cacheNames = { "warning" })
public class WarningService {
    private static final Logger LOG = LoggerFactory.getLogger(WarningService.class);
    @Autowired
    private WarningRepository warningRepo;

    public void add(Warning warning) {
        warningRepo.save(warning);
    }

    @Cacheable(unless = "#result==null",key = "#root.args[0]")
    public Warning get(WarningPK key) {
        LOG.info("get warning no hit in cache");
        Optional<Warning> warning = warningRepo.findById(key);
        if (warning.isPresent()) {
            return warning.get();
        }
        return null;
    }

 @CacheEvict(key = "#root.args[0].getWarningKey()")
    public void remove(Warning warning) {
        warningRepo.delete(warning);
    }

}
