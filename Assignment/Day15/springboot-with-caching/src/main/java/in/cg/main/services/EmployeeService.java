package in.cg.main.services;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import in.cg.main.dto.AddressDto;
import in.cg.main.dto.EmployeeDto;
import in.cg.main.entities.AddressEntity;
import in.cg.main.entities.EmployeeEntity;
import in.cg.main.repositories.EmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService {

	private final EmployeeRepository userRepository;

	public EmployeeService(EmployeeRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public EmployeeDto addUserDetails(EmployeeDto ud) {
		EmployeeEntity entity = dtoToEntity(ud);
		userRepository.save(entity);
		return entityToDto(entity);
	}

	@Cacheable(value="emp", key = "#id")
	public EmployeeDto getUserById(int id) {
		System.out.println("Fetching the data from db with id:"+id);
		return entityToDto(userRepository.findById(id).get());
	}

	@Cacheable(value="empList")
	public List<EmployeeDto> allUsers() {
		return userRepository.findAll().stream().map(this::entityToDto).toList();
	}

	public EmployeeDto updateUserDetails(int id, EmployeeDto ud) {
		EmployeeEntity entity = userRepository.findById(id).get();

		if (ud.getDesignation() != null) {
			entity.setDesignation(ud.getDesignation());
		}
		if (ud.getName() != null) {
			entity.setName(ud.getName());
		}
		if (ud.getEmail() != null) {
			entity.setEmail(ud.getEmail());
		}
		if(ud.getAddress()!=null) {
			entity.setAddressEntity(dtoToEntity(ud.getAddress()));
		}
		return entityToDto(entity);
	}

	@CacheEvict(value= {"emps","empList"}, allEntries = true)
	public boolean deleteWithId(int id) {
		try {
			userRepository.delete(userRepository.findById(id).get());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<EmployeeDto> getALlUserConfidential() {
		return userRepository.findAll().stream().map(emp -> {
			EmployeeDto dto = new EmployeeDto();
			dto.setAddress(entityToDto(emp.getAddressEntity()));
			dto.setDesignation(emp.getDesignation());
			dto.setEmail(emp.getEmail());
			dto.setName(emp.getName());
			return dto;
		}).toList();
	}

	private EmployeeDto entityToDto(EmployeeEntity ue) {
		EmployeeDto ud = new EmployeeDto();
		ud.setAddress(entityToDto(ue.getAddressEntity()));
		ud.setDesignation(ue.getDesignation());
		ud.setEmail(ue.getEmail());
		ud.setName(ue.getName());
		ud.setId(ue.getId());
		return ud;
	}

	private EmployeeEntity dtoToEntity(EmployeeDto dto) {
		EmployeeEntity ue = new EmployeeEntity();
		ue.setAddressEntity(dtoToEntity(dto.getAddress()));
		ue.setDesignation(dto.getDesignation());
		ue.setEmail(dto.getEmail());
		ue.setName(dto.getName());
		return ue;
	}

	private AddressDto entityToDto(AddressEntity ae) {
		AddressDto ad = new AddressDto();
		ad.setCity(ae.getCity());
		ad.setHouseNo(ae.getHouseNo());
		ad.setPincode(ae.getPincode());
		ad.setStreet(ae.getStreet());
		return ad;
	}
	
	private AddressEntity dtoToEntity(AddressDto dto) {
		AddressEntity ent = new AddressEntity();
		ent.setCity(dto.getCity());
		ent.setHouseNo(dto.getHouseNo());
		ent.setPincode(dto.getPincode());
		ent.setStreet(dto.getStreet());
		return ent;
		
	}
}
