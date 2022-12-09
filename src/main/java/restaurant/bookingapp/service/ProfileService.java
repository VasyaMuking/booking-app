package restaurant.bookingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import restaurant.bookingapp.anntotation.Retry;
import restaurant.bookingapp.model.ProfileEntity;
import restaurant.bookingapp.model.ProfileRole;
import restaurant.bookingapp.repository.ProfileRepository;
import restaurant.bookingapp.security.JwtProvider;

@Service
public class ProfileService implements UserDetailsService {
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return profileRepository.findByLogin(username);
    }

    @Retry
    public void register(ProfileEntity profile) {
        profile.setPassword(encoder.encode(profile.getPassword()));
        profile.setRole(ProfileRole.USER);
        profileRepository.save(profile);
    }

    public String auth(String login, String password) {
        ProfileEntity profile = profileRepository.findByLogin(login);
        if (encoder.matches(password, profile.getPassword())) {
            return jwtProvider.generateToken(login);
        }

        return null;
    }
}
