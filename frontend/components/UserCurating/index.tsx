import React from "react";
import styled from "@emotion/styled";
import Button from "../Button";
import color from "../../styles/theme";
import Image from "next/image";
import TopLeft from "../UserCurating/TopLeft";
import TopRight from "../UserCurating/TopRight";

const Container = styled.div`
  display: flex;
  width: 100%;
  max-width: 930px;
  margin-top: 152px;
  margin-bottom: 10px;
`;

const Container2 = styled.div`
  display: flex;
  width: 1280px;
  border-bottom: solid ${color.gray.default} 2px;
`;

const Wrapper2 = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  width: 100%;
  max-width: 640px;
  margin-right: auto;
  margin-left: 10px;
`;

const index = ({ userData, routerQuery }) => {
  const {
    userImg,
    userName,
    userBox,
    userFollowing,
    userFollower,
    userPosts,
    userLikes,
    userTags,
    userCollections,
  } = userData;

  return (
    <>
      <Container>
        <TopLeft userImg={userImg}></TopLeft>
        <Wrapper2>
          <TopRight
            userName={userName}
            userBox={userBox}
            userFollowing={userFollowing}
            userFollower={userFollower}
            userPosts={userPosts}
            userTags={userTags}
            routerQuery={routerQuery}
          ></TopRight>
        </Wrapper2>
      </Container>
    </>
  );
};

export default index;