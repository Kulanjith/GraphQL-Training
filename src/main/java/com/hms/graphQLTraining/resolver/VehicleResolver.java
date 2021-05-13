package com.hms.graphQLTraining.resolver;

import com.hms.graphQLTraining.domain.vehicle.BaseVehicle;
import com.hms.graphQLTraining.domain.vehicle.Car;
import com.hms.graphQLTraining.domain.vehicle.Van;
import com.hms.graphQLTraining.repository.VehicleRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class VehicleQueryResolver implements GraphQLQueryResolver {

    private final VehicleRepository vehicleRepository;

    public VehicleQueryResolver(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
        vehicleRepository.saveVehicle(new Van("Van100", BaseVehicle.HosePower.HP_3000, true));
        vehicleRepository.saveVehicle(new Car("Car 120", BaseVehicle.HosePower.HP_1500));

    }

    public List<? extends BaseVehicle> findVehicleList() {
        return vehicleRepository.findAll();
    }
}


@Component
class VehicleMutationResolver implements GraphQLMutationResolver {

    private final VehicleRepository vehicleRepository;

    public VehicleMutationResolver(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Boolean saveCar(String id, BaseVehicle.HosePower enginePower) {
        return vehicleRepository.saveVehicle(new Car(id, enginePower));
    }
}
