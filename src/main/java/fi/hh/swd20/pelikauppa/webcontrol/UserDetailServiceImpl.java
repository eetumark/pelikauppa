package fi.hh.swd20.pelikauppa.webcontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fi.hh.swd20.pelikauppa.domain.User;
import fi.hh.swd20.pelikauppa.domain.UserRepository;

	@Service
	public class UserDetailServiceImpl implements UserDetailsService {
		private final UserRepository userrepository;
		
		@Autowired
		public UserDetailServiceImpl(UserRepository userRepository) {
			this.userrepository = userRepository;
		}
		
		@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			User curruser = userrepository.findByUsername(username);
			UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPasswordHash(),
				AuthorityUtils.createAuthorityList(curruser.getRole()));
			return user;
		}
	}

