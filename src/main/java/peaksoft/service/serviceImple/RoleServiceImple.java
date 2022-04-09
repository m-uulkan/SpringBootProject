package peaksoft.service.serviceImple;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.model.Role;
import peaksoft.repository.RoleRepository;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class RoleServiceImple {

    private final RoleRepository roleRepository;

    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
}
