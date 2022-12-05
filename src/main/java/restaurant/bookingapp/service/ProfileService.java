package restaurant.bookingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import restaurant.bookingapp.model.ProfileEntity;
import restaurant.bookingapp.repository.ProfileRepository;

public class ProfileService {
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
//        profile.setRole(ProfileRole.HR);
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
