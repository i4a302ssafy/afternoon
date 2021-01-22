import React from "react";
import styled from "@emotion/styled";
import color from "../../styles/theme";
import Image from "next/image";

const Container = styled.div`
  display: flex;
  flex-direction: column;
  width: 300px;
  margin-bottom: 10px;
`;

const LogoBox = styled.div`
  width: 300px;
  height: 50px;
  position: relative;
  display: flex;
  justify-content: center;
  align-items: center;
  margin-bottom: 8px;
`;

const ModalTitle = styled.div`
  display: flex;
  width: 300px;
  margin-top: 3px;
  justify-content: center;
  align-items: center;
  color: ${color.black.default};
  font-size: 20px;
  font-weight: 50px;
`;

const ModalText = styled.div`
  display: flex;
  width: 300px;
  margin-bottom: 20px;
  justify-content: center;
  align-items: center;
  font-size: 12px;
  color: ${color.black.default};
`;

const UserModalTop = () => {
  return (
    <Container>
      <LogoBox>
        <Image
          src="/assets/logos/pinset_logo_black.png"
          layout="fill"
          objectFit="contain"
        ></Image>
      </LogoBox>
      <ModalTitle>PINSET에 오신 것을 환영합니다</ModalTitle>
      <ModalText>당신의 공간을 공유하세요</ModalText>
    </Container>
  );
};

export default UserModalTop;
