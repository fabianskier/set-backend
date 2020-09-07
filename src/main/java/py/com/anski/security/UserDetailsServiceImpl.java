package py.com.anski.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import py.com.anski.model.Usuario;
import py.com.anski.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  UsuarioRepository usuarioRepository;
  
  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      Usuario user = usuarioRepository.findByUsername(username)
              .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

      return UserDetailsImpl.build(user);
  }
}
