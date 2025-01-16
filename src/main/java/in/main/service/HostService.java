package in.main.service;

import in.main.dtos.HostDto;
import in.main.entities.Host;

public interface HostService {

	public Host createHost(HostDto host);
}
