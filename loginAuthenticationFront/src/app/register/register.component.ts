import { Component, OnInit } from "@angular/core";
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from "@angular/forms";
import { AppService } from "../app.service";

@Component({
  selector: "app-register",
  templateUrl: "./register.component.html",
  styleUrls: ["./register.component.css"],
})
export class RegisterComponent implements OnInit {
  registerInfo: FormGroup;

  constructor(private service: AppService, private formBuilder: FormBuilder) {
    this.registerInfo = this.formBuilder.group({
      name: [null, [Validators.maxLength(60), Validators.required]],
      username: [null, [Validators.maxLength(60), Validators.required]],
      password: [
        null,
        [
          Validators.maxLength(40),
          Validators.minLength(4),
          Validators.required,
        ],
      ],
      email: [
        null,
        [
          Validators.minLength(5),
          Validators.maxLength(250),
          Validators.required,
        ],
      ],
      phone: [null, [Validators.maxLength(12), Validators.required]],
      bio: [null, [Validators.maxLength(260), Validators.required]],
    });
  }

  ngOnInit() {}

  registrar() {
    const infos = {
      name: this.registerInfo.value.name,
      email: this.registerInfo.value.email,
      phone: this.registerInfo.value.phone,
      bio: this.registerInfo.value.bio,
      username: this.registerInfo.value.username,
      password: this.registerInfo.value.password,
    };
    if (this.registerInfo.status == "VALID") {
      try {
        // this.service.register(infos).subscribe();
        console.log(infos);
      } catch (e) {
        console.log("erro do tipo" + e.message);
      }
    } else {
      window.alert("alguma coisa deu errada!verifique os campos digitados");
    }
  }
}
