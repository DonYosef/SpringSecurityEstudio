package com.app;

import com.app.persistence.entity.PermissionEntity;
import com.app.persistence.entity.RoleEnum;
import com.app.persistence.entity.RolesEntity;
import com.app.persistence.entity.UserEntity;
import com.app.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SpringSecurityAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityAppApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository){
		return args -> {
			//CREATE PERMISSIONS
			PermissionEntity createPermission = PermissionEntity.builder()
					.name("CREATE")
					.build();

			PermissionEntity readPermission = PermissionEntity.builder()
					.name("READ")
					.build();

			PermissionEntity updatePermission = PermissionEntity.builder()
					.name("UPDATE")
					.build();

			PermissionEntity deletePermission = PermissionEntity.builder()
					.name("DELETE")
					.build();

			PermissionEntity refractorPermission = PermissionEntity.builder()
					.name("REFRACTOR")
					.build();

			// CREATE ROLES

			RolesEntity roleAdmin = RolesEntity.builder()
					.roleEnum(RoleEnum.ADMIN)
					.permissionList(Set.of(createPermission,readPermission,updatePermission,deletePermission))
					.build();

			RolesEntity roleUser = RolesEntity.builder()
					.roleEnum(RoleEnum.USER)
					.permissionList(Set.of(createPermission,readPermission))
					.build();

			RolesEntity roleInvited = RolesEntity.builder()
					.roleEnum(RoleEnum.INVITED)
					.permissionList(Set.of(readPermission))
					.build();

			RolesEntity roleDeveloper = RolesEntity.builder()
					.roleEnum(RoleEnum.DEVELOPER)
					.permissionList(Set.of(createPermission,readPermission,updatePermission,deletePermission, refractorPermission))
					.build();

			//CREATE USERS
			UserEntity userSantiago = UserEntity.builder()
					.username("santiago")
					.password(new BCryptPasswordEncoder().encode("1234"))
					.isEnabled(true)
					.credentialNoExpired(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.roles(Set.of(roleAdmin))
					.build();

			UserEntity userJavier = UserEntity.builder()
					.username("javier")
					.password(new BCryptPasswordEncoder().encode("1234"))
					.isEnabled(true)
					.credentialNoExpired(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.roles(Set.of(roleUser))
					.build();

			UserEntity userInvitada = UserEntity.builder()
					.username("invitada")
					.password( new BCryptPasswordEncoder().encode("1234"))
					.isEnabled(true)
					.credentialNoExpired(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.roles(Set.of(roleInvited))
					.build();

			userRepository.saveAll(List.of(userSantiago,userJavier,userInvitada));
		};
	}

}
