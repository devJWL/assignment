package org.junwoo.coding.assignment1.domain.device.repository;

import org.junwoo.coding.assignment1.domain.device.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {

}