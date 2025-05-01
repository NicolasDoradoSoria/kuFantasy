package ar.edu.unsam.phm

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@SpringBootApplication

class KuFantasyApp

fun main(args: Array<String>) {
  runApplication<KuFantasyApp>(*args)
}