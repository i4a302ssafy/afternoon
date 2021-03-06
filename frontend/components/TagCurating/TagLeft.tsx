import React from "react";
import styled from "@emotion/styled";
import color from "../../styles/theme";

const Container = styled.div`
  display: flex;
  width: 100%;
  flex-direction: column;
  justify-content: space-between;
  @media only screen and (max-width: 768px) {
    margin-bottom: 20px;
  }
  @media only screen and (min-width: 768px) {
    margin-right: 20px;
  }
  @media only screen and (min-width: 1280px) {
    margin-right: 60px;
  }
`;

const TextBox = styled.div`
  display: flex;
  flex-direction: column;
`;

const TitleText = styled.div`
  display: flex;
  color: ${color.black.default};
  font-weight: bold;
  font-size: 40px;
  margin-bottom: 30px;
  @media only screen and (max-width: 768px) {
    margin-bottom: 20px;
  }
`;

const ContentText = styled.div`
  display: flex;
  color: ${color.black.default};
  line-height: 28px;
  font-size: 16px;
`;

const TagLeft = ({ tagTitle, tagDesc }) => {
  return (
    <Container>
      <TextBox>
        <TitleText>{tagTitle}</TitleText>
        <ContentText>{tagDesc}</ContentText>
      </TextBox>
    </Container>
  );
};

export default TagLeft;
