let
  pkgs = import <nixpkgs> {};
in
pkgs.mkShell {
  buildInputs = [
    pkgs.jdk8
    pkgs.sbt
    pkgs.pandoc
  ];
}
