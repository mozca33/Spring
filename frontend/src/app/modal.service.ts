import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ModalService {
  private registerModalState = new BehaviorSubject<boolean>(false);
  private loginModalState = new BehaviorSubject<boolean>(false);

  isRegisterModalOpen$ = this.registerModalState.asObservable();
  isLoginModalOpen$ = this.loginModalState.asObservable();

  openLoginModal() {
    if (this.isRegisterModalOpen$) {
      this.closeRegisterModal();
    }

    this.loginModalState.next(true);
  }

  openRegisterModal() {
    if (this.isLoginModalOpen$) {
      this.closeLoginModal();
    }

    this.registerModalState.next(true);
  }

  closeLoginModal() {
    setTimeout(() => {
      this.loginModalState.next(false);
    }, 0);
  }

  closeRegisterModal() {
    setTimeout(() => {
      this.registerModalState.next(false);
    }, 0);
  }
}
