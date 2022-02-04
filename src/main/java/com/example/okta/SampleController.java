package com.example.okta;

import java.io.IOException;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SampleController {

	@GetMapping("/")
	public ModelAndView home(@AuthenticationPrincipal OidcUser user, ModelAndView mav) throws IOException {
		if(user != null) {
			mav.addObject("email", user.getEmail());
		}
		mav.setViewName("home");
		return mav;
	}

}
