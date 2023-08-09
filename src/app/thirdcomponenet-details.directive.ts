import { Directive } from '@angular/core';
import {  ElementRef, HostListener } from '@angular/core';
@Directive({
  selector: '[appThirdcomponenetDetails]'
})
export class ThirdcomponenetDetailsDirective {
  private elementSelected = false;
  @HostListener('click')
  private onClick() {
    this.elementSelected = !this.elementSelected;
    if (this.elementSelected) {
      this.el.nativeElement.classList.add('toggle')
    } else {
      this.el.nativeElement.classList.remove('toggle')
    }
  }
  constructor(private el: ElementRef) { }

}
